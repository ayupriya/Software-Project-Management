package com.courierService.dao;
import com.courierService.bin.BBillReceiveDetail;
import com.courierService.DBConnection;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class DBillReceiveDetail
{
	Connection con;
	public DBillReceiveDetail()
	{
		con=DBConnection.getDBConnection();
	}
	public String insertData(BBillReceiveDetail bbrd)throws SQLException
	{
		PreparedStatement ps=null;
		String retValue=null;
		
		//use insert query to insert data in data base
		try
		{
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			java.util.Date billReceiveDate=format.parse(bbrd.getBillReceiveDate());
			java.sql.Date billReceiveDate1= new java.sql.Date( billReceiveDate.getTime() );
	
			
			ps=con.prepareStatement("insert into billreceivedetail(billReceiveCustomerId, billReceiveOfficeId, billReceiveManagerId, billReceiveDate, billReceiveRemark, billReceiveAmount, billReceiveInvoiceNumber) values(?,?,?,?,?,?,?)");
			

			ps.setInt(1, Integer.parseInt(bbrd.getBillReceiveCustomerId()));
			ps.setInt(2, Integer.parseInt(bbrd.getBillReceiveOfficeId()));
			ps.setInt(3, Integer.parseInt(bbrd.getBillReceiveManagerId()));
			ps.setDate(4, billReceiveDate1);
			ps.setString(5, bbrd.getBillReceiveRemark());
			ps.setInt(6, Integer.parseInt(bbrd.getBillReceiveAmount()));
			ps.setInt(7, Integer.parseInt(bbrd.getBillReceiveInvoiceNumber()));
			
			
			retValue=String.valueOf(ps.executeUpdate());
			
		}
		catch (Exception e)
		{
			retValue=e.toString();
		}
		finally
		{
			ps.close();
		}
		return retValue;
	}
	
	//FUNCTION to get only balance sheet Detail
	public List<BBillReceiveDetail> getBillReceiveDetail(int customerId)
	{
		PreparedStatement ps=null;
		String retValue=null;
		ResultSet rs=null;
		String dateString = null;
		
		List<BBillReceiveDetail> lbbrd = new ArrayList<BBillReceiveDetail>();
		try
		{
			ps=con.prepareStatement("select billReceiveInvoiceNumber, billReceiveDate, billReceiveRemark, billReceiveAmount from billreceivedetail where billReceiveCustomerId=?");
			ps.setInt(1, customerId);
			ps.execute();
			rs=ps.getResultSet();
			while (rs.next()) 
			{
				BBillReceiveDetail bbrd = new BBillReceiveDetail();
				bbrd.setBillReceiveInvoiceNumber(String.valueOf(rs.getInt("billReceiveInvoiceNumber")));
				bbrd.setBillReceiveAmount(String.valueOf(rs.getInt("billReceiveAmount")));
				bbrd.setBillReceiveRemark(String.valueOf(rs.getString("billReceiveRemark")));
				
				SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy");
				
				dateString = sdfr.format( rs.getDate("billReceiveDate") );
				bbrd.setBillReceiveDate(String.valueOf(dateString));
				
				
				
				
				lbbrd.add(bbrd);
			}
		}
		catch (Exception e)
		{
			System.out.println("Error");
		}
		return lbbrd;
	}
}
