package com.cognizant.flightbooking.ids;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AddFlightIdGenerator  implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		 String prefix = "FN";
//	        Connection connection = session.connection();
//
//	        try {
//	            Statement statement=connection.createStatement();
//
//	            ResultSet rs=statement.executeQuery("select flight_number");
//
//	            if(rs.next())
//	            {
//	                int id=rs.getInt(1)+101;
//	                String generatedId = prefix + new Integer(id).toString();
//	                System.out.println("Generated Id: " + generatedId);
//	                return generatedId;
//	            }
//	        } catch (SQLException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }


	        return null;

	}

}
