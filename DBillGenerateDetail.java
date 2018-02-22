package com.courierService.dao;
import com.courierService.bin.BBillGenerateDetail;
import com.courierService.DBConnection;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class DBillGenerateDetail
{
	Connection con;
	public DBillGenerateDetail()
	{
		con=DBConnection.getDBConnection();
	}
	public String insertData(BBillGenerateDetail bbgd)throws SQLException
	{
		PreparedStatement ps=null;
		String retValue=null;
		
		//use insert query to insert data in data base
		try
		{
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			java.util.Date billGenerateDate=format.parse(bbgd.getBillGenerateDate());
			java.sql.Date billGenerateDate1= new java.sql.Date( billGenerateDate.getTime() );
			
			java.util.Date billFirstDate=format.parse(bbgd.getBillFirstDate());
			java.sql.Date billFirstDate1= new java.sql.Date( billFirstDate.getTime() );
			
			java.util.Date billSecondDate=format.parse(bbgd.getBillSecondDate());
			java.sql.Date billSecondDate1= new java.sql.Date( billSecondDate.getTime() );
			
			ps=con.prepareStatement("insert into billgeneratedetail(billNumber, billOfficeId, billCustomerId, billGenerateDate, billRemark, billManagerId, billFirstDate, billSecondDate, billAmount) values(?,?,?,?,?,?,?,?,?)");
			

			ps.setInt(1, Integer.parseInt(bbgd.getBillNumber()));
			ps.setInt(2, Integer.parseInt(bbgd.getBillOfficeId()));
			ps.setInt(3, Integer.parseInt(bbgd.getBillCustomerId()));
			ps.setDate(4, billGenerateDate1);
			ps.setString(5, bbgd.getBillRemark());
			ps.setInt(6, Integer.parseInt(bbgd.getBillManagerId()));
			ps.setDate(7, billFirstDate1);
			ps.setDate(8, billSecondDate1);
			ps.setInt(9, Integer.parseInt(bbgd.getBillAmount()));
			
			
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
	
	//FUNCTION to get only balance sheet detail Detail
			public List<BBillGenerateDetail> getBillGenerateDetail(int customerId)
			{
				PreparedStatement ps=null;
				String retValue=null;
				ResultSet rs=null;
				String dateString = null;
				String dateStringFirst = null;
				String dateStringSecond = null;
				List<BBillGenerateDetail> lbbgd = new ArrayList<BBillGenerateDetail>();
				try
				{
					ps=con.prepareStatement("select billNumber, billGenerateDate, billRemark, billFirstDate, billSecondDate, billAmount from billgeneratedetail where billCustomerId=?");
					ps.setInt(1, customerId);
					ps.execute();
					rs=ps.getResultSet();
					while (rs.next()) 
					{
						BBillGenerateDetail bbgd = new BBillGenerateDetail();
						bbgd.setBillNumber(String.valueOf(rs.getInt("billNumber")));
						bbgd.setBillAmount(String.valueOf(rs.getInt("billAmount")));
						bbgd.setBillRemark(String.valueOf(rs.getString("billRemark")));
						
						SimpleDateFormat sdfr = new SimpleDateFormat("dd-MM-yyyy");
						
						dateString = sdfr.format( rs.getDate("billGenerateDate") );
						bbgd.setBillGenerateDate(String.valueOf(dateString));
						
						
						dateStringFirst = sdfr.format( rs.getDate("billFirstDate") );
						bbgd.setBillFirstDate(String.valueOf(dateStringFirst));
						
						
						dateStringSecond = sdfr.format( rs.getDate("billSecondDate") );
						bbgd.setBillSecondDate(String.valueOf(dateStringSecond));
						//System.out.println(dateString);
						//bcd.setConsignmentPickupDate(String.valueOf(rs.getDate("consignmentPickupDate")));
						lbbgd.add(bbgd);
					}
				}
				catch (Exception e)
				{
					System.out.println("Error");
				}
				return lbbgd;
			}
			
	
}
