package com.dteam.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dteam.app.dto.MdDto;
import com.dteam.app.dto.MemberDto;


public class ANDao {

	DataSource dataSource;

	public ANDao() {
		try {
			Context context = new InitialContext();
			/* dataSource = (DataSource) context.lookup("java:/comp/env/team01"); */
			 dataSource = (DataSource) context.lookup("java:/comp/env/dteam"); 
			/*dataSource = (DataSource) context.lookup("java:/comp/env/CSS");*/
		} catch (NamingException e) {
			e.getMessage();
		}

	}
	
	
    public MemberDto anLogin(String id, String pw) {

    	MemberDto adto = null;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;		
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * "					
							+ " from tblmember" 
							+ " where member_id = '" + id + "' and member_pw = '" + pw + "' ";
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				String member_id = resultSet.getString("member_id");
				String member_pw = resultSet.getString("member_pw");
				String member_nickname = resultSet.getString("member_nickname");
				String member_tel = resultSet.getString("member_tel"); 
				String member_addr = resultSet.getString("member_addr");
				String member_latitude = resultSet.getString("member_latitude");
				String member_longitude = resultSet.getString("member_longitude");
				int member_grade = resultSet.getInt("member_grade");
				//int member_grade = Integer.parseInt(resultSet.getString("member_grade")); 
				String member_name = resultSet.getString("member_name"); 

				adto = new MemberDto(member_id, member_nickname, member_tel, member_addr, 
								     member_latitude, member_longitude, member_grade, member_name);							
			}	
			
			System.out.println("MemberDTO id : " + adto.getMember_id());
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} finally {
			try {			
				
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adto;

	}

    public int anJoin(String member_id, String member_pw, String member_nickname, 
    				  String member_tel, String member_addr, String member_latitude, 
    				  String member_longitude, String member_name) { 
    	
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int state = -100;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into tblmember(member_id, member_pw, member_nickname, member_tel, " + 
						  "member_addr, member_latitude, member_longitude, member_name) " + 
			               "values('" + member_id + "', '" + member_pw + "', '" + member_nickname + "', '" + 
			               member_tel + "', '" + member_addr + "', '" + member_latitude + "', '" + 
			               member_longitude + "', '" + member_name + "' )";
			prepareStatement = connection.prepareStatement(sql);
			state = prepareStatement.executeUpdate();
			
			if (state > 0) {
				System.out.println(state + "삽입성공");				
			} else {
				System.out.println(state + "삽입실패");
			}
			
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		} finally {
			try {				
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return state;
	}


    
	public MdDto anDetail(String md_serial_number) {
		
		MdDto mdDto = null;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * "
						+ "from tblmerchandise "
						+ "where md_serial_number ='"+md_serial_number+"'";
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				String md_name = resultSet.getString("md_name");
				String md_category = resultSet.getString("md_category");
				int md_price = resultSet.getInt("md_price");
				String md_rental_term = resultSet.getString("md_rental_term");
				int md_deposit = resultSet.getInt("md_deposit");
				String md_detail_content = resultSet.getString("md_detail_content");
				String md_photo_url = resultSet.getString("md_photo_url");
				String member_id = resultSet.getString("member_id");
				String member_addr = resultSet.getString("member_addr");
				int md_fav_count = resultSet.getInt("md_fav_count");
				String md_registration_date = resultSet.getString("md_registration_date");
				md_serial_number = resultSet.getString("md_serial_number");
				int md_rent_status = resultSet.getInt("md_rent_status");
				int md_hits = resultSet.getInt("md_hits");
				
				mdDto = new MdDto(md_name, md_category, md_price, md_rental_term, md_deposit,
						md_detail_content, md_photo_url, member_id, member_addr, md_fav_count, 
						md_registration_date, md_serial_number, md_rent_status, md_hits);
			}
			System.out.println("md_serial_number : " + mdDto.getMd_serial_number());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {			
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}
		return mdDto;
	}


	

    /*
	public ArrayList<ANDto> anSelectMulti() {		
		
		ArrayList<ANDto> adtos = new ArrayList<ANDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;		
		
		try {
			connection = dataSource.getConnection();
			String query = "select id, name, hire_date, image_path "					
							+ " from android" 
							+ " order by id desc";
			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Date date = resultSet.getDate("hire_date"); 
				String imagePath = resultSet.getString("image_path"); 

				ANDto adto = new ANDto(id, name, date, imagePath);
				adtos.add(adto);			
			}	
			
			System.out.println("adtos크기" + adtos.size());
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} finally {
			try {			
				
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adtos;

	}
	*/
    
	/*
	public int anInsertMulti(int id, String name, String date, String dbImgPath) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
				
		int state = -1;

		try {			
			// 
			connection = dataSource.getConnection();
			String query = "insert into android(id, name, hire_date, image_path) " + "values(" + id + ",'" 
							+ name + "'," + "to_date('" + date + "','rr/mm/dd') , '" + dbImgPath + "' )";

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();
			
			if (state > 0) {
				System.out.println(state + "삽입성공");				
			} else {
				System.out.println(state + "삽입실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} 

		}

		return state;

	}
	*/
    /*
	public int anUpdateMulti(int id, String name, String date, String dbImgPath) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		int state = -1;
	
		try {			
			// 아이디는 수정할수 없음			
			connection = dataSource.getConnection();
			String query = "update android set " 			             
		             + " name = '" + name + "' "
		             + ", hire_date = '" + date + "' "
		             + ", image_path = '" + dbImgPath + "' "
					 + " where id = " + id ;
			
			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();
	
			if (state > 0) {
				System.out.println("수정1성공");
				
			} else {
				System.out.println("수정1실패");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
	
			}
		}
	
		return state;
	
	}
	*/
    /*
	public int anUpdateMultiNo(int id, String name, String date) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		int state = -1;
	
		try {			
			// 아이디는 수정할수 없음			
			connection = dataSource.getConnection();
			String query = "update android set " 			             
		             + " name = '" + name + "' "
		             + ", hire_date = '" + date + "' "		             
					 + " where id = " + id ;
			
			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();
	
			if (state > 0) {
				System.out.println("수정2성공");
				
			} else {
				System.out.println("수정2실패");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
	
			}
		}
	
		return state;
	}
	*/
    /*
	public int anDeleteMulti(int id) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		int state = -1;

		try {
			connection = dataSource.getConnection();
			String query = "delete from android where id=" + id;
			
			System.out.println(id);

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println("삭제성공");				
			} else {
				System.out.println("삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return state;

	}
	*/
		
	
	
}
