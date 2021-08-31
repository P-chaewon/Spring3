package com.cw.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cw.s1.util.DBConnect;

@Repository
public class BankBookDAO {
	
	private DBConnect dbConnect;
	
	public BankBookDAO() {
		
	}
	
	@Autowired
	public BankBookDAO(DBConnect dbConnect) {
		this.dbConnect = dbConnect;
	}
	public void setDbConnect(DBConnect dbConnect) {
		this.dbConnect = dbConnect;
	}
	//setInsert
	public int setInsert(BankBookDTO bankBookDTO) {
		Connection con=dbConnect.getConnect();
		PreparedStatement st=null;
		ResultSet rs=null;
		int result = 0;
		
		String sql="INSERT INTO BANKBOOK (BOOKNUM, BOOKNAME, BOOKRATE, BOOKSALE) "
				+ "VALUES (BANKBOOK_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			st=con.prepareStatement(sql);
			st.setString(1, bankBookDTO.getBookName());
			st.setDouble(2, bankBookDTO.getBookRate());
			st.setInt(3, bankBookDTO.getBookSale());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(st, con);
		}
		return result;
	}
	
	
	public ArrayList<BankBookDTO> getList() {
		Connection con=dbConnect.getConnect();
		PreparedStatement st=null;
		ResultSet rs=null;
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		String sql="SELECT * FROM BANKBOOK";
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNum(rs.getLong("bookNum"));
				bankBookDTO.setBookName(rs.getString("bookName"));
				bankBookDTO.setBookRate(rs.getDouble("bookRate"));
				bankBookDTO.setBookSale(rs.getInt("bookSale"));
				ar.add(bankBookDTO);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		return ar;
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		
		Connection con=dbConnect.getConnect();
		PreparedStatement st=null;
		ResultSet rs=null;
		BankBookDTO result=null;
		
		String sql="SELECT * FROM BANKBOOK WHERE BOOKNUM=?";
		try {
			st = con.prepareStatement(sql);
			st.setLong(1, bankBookDTO.getBookNum());
			rs = st.executeQuery();
	
			if(rs.next()) {
				result = new BankBookDTO();
				result.setBookNum(rs.getLong("bookNum"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return result;
		
	}
	
}
				
				
