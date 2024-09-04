package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.model.Register;

public class RegisterDaoImpl implements RegisterDao {

	@Override
	public int registerHere(List<Register> lst) {
		Connection con=DBConnection.myConnection();
		
		int i=0;
		Register r = lst.get(0); 
		try {
				PreparedStatement pstate=con.prepareStatement("insert into register values(?,?,?,?,?,?)");
				pstate.setInt(1,r.getRegNo() );
				pstate.setString(2, r.getFname());
				pstate.setString(3, r.getLname());
				pstate.setString(4, r.getEmail());
				pstate.setString(5, r.getPass());
				pstate.setFloat(6, r.getAmt());
				i = pstate.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return i;	
	}
	
	
	

}
