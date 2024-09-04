package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.model.Login;
import com.model.Recharge;
import com.model.Register;

public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean validation(List<Login> lst) {
       Connection con=DBConnection.myConnection();
		
		boolean b=false;
		Login lobj = lst.get(0);
		
		try {
			PreparedStatement pstate = con.prepareStatement("select * from register where regno=? and email=? and pass=?");
			pstate.setInt(1, lobj.getRegno());
			pstate.setString(2, lobj.getLemail());
			pstate.setString(3, lobj.getLpass());
			ResultSet result = pstate.executeQuery();
			if(result.next()) {
				System.out.println("Valid User");
				b=true;
			}
			else {
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	
	public int recharge(List<Recharge> lstr) {
		int updateResult=0;
		Connection con=DBConnection.myConnection();
		PreparedStatement pstate;
		PreparedStatement state;
		Recharge r = lstr.get(0);
		int i=0;
		String str = "select amt from register where regNo = ?";
		try {
			pstate=con.prepareStatement(str);
			pstate.setInt(1,r.getRegNo());
			ResultSet re=pstate.executeQuery();
			if(re.next()) {
				float currentAmt =re.getFloat("amt");
			    float newAmt = currentAmt - r.getRamt();
			    String updateRegister = "update register set amt = ? where regNo = ?";
			    state = con.prepareStatement(updateRegister);
			    state.setFloat(1, newAmt);
			    state.setInt(2, r.getRegNo());
			    updateResult = state.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(updateResult>0) {
			try {
				PreparedStatement pstate1 = con.prepareStatement("insert into recharge values (?, ?, ?, ?)");
				pstate1.setInt(1,r.getRegNo() );
				pstate1.setString(2, r.getMobNo());
				pstate1.setString(3, r.getSer());
				pstate1.setFloat(4, r.getRamt());
				i=pstate1.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
		}
		
		
		
		return i;
		
	}
	
	
	public List<Recharge> displayAll(int regNo) {
		Connection con=DBConnection.myConnection();
		String str="select * from recharge where regno=?";
		
		
		List<Recharge> lst=new LinkedList<Recharge>();
		PreparedStatement state;
		try {
			state=con.prepareStatement(str);
			state.setInt(1, regNo);
			ResultSet rs=state.executeQuery();
			while(rs.next()) {
				Recharge re=new Recharge(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
				lst.add(re);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	
	public boolean addBalance(int regno, float amount) {
        Connection con = DBConnection.myConnection();
        boolean success = false;
        ResultSet rs;
			try {
				PreparedStatement pstate = con.prepareStatement("select amt from register where regno = ?");
				pstate.setInt(1, regno);
				rs = pstate.executeQuery();
				if (rs.next()) {
	                float currentAmt = rs.getFloat("amt");
	                float newAmt = currentAmt + amount;
	                System.out.println("hii");
	                String updateQuery = "UPDATE register set amt = ? WHERE regno = ?";
	                PreparedStatement updateState = con.prepareStatement(updateQuery);
	                updateState.setFloat(1, newAmt);
	                updateState.setInt(2, regno);
	                int rowsAffected = updateState.executeUpdate();
	                if (rowsAffected > 0) {
		                success = true;
		                System.out.println("Added");
		            }
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        return success;
    }
	
	public float checkBalance(int regno) {
		Connection con = DBConnection.myConnection();
   
        ResultSet rs;
        float balance=0;
        try {
			PreparedStatement pstate = con.prepareStatement("select amt from register where regno = ?");
			pstate.setInt(1, regno);
			rs = pstate.executeQuery();
			if (rs.next()) {
               
				balance=rs.getFloat("amt");;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    return balance;
	}
	
	

}
