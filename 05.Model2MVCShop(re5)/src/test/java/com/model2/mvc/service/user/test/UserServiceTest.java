package com.model2.mvc.service.user.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;


/*
 *	FileName :  UserServiceTest.java
 * 占쏙옙 JUnit4 (Test Framework) 占쏙옙 Spring Framework 占쏙옙占쏙옙 Test( Unit Test)
 * 占쏙옙 Spring 占쏙옙 JUnit 4占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 클占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙 占쌓쏙옙트 占쌘드를 占쌜쇽옙 占쏙옙 占쏙옙 占쌍댐옙.
 * 占쏙옙 @RunWith : Meta-data 占쏙옙 占쏙옙占쏙옙 wiring(占쏙옙占쏙옙,DI) 占쏙옙 占쏙옙체 占쏙옙占쏙옙체 占쏙옙占쏙옙
 * 占쏙옙 @ContextConfiguration : Meta-data location 占쏙옙占쏙옙
 * 占쏙옙 @Test : 占쌓쏙옙트 占쏙옙占쏙옙 占쌀쏙옙 占쏙옙占쏙옙
 */
@RunWith(SpringJUnit4ClassRunner.class)

//==> Meta-Data 占쏙옙 占쌕억옙占싹곤옙 Wiring 占쏙옙占쏙옙...
//@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
																	"classpath:config/context-aspect.xml",
																	"classpath:config/context-mybatis.xml",
																	"classpath:config/context-transaction.xml" })
//@ContextConfiguration(locations = { "classpath:config/context-common.xml" })
public class UserServiceTest {

	//==>@RunWith,@ContextConfiguration 占싱울옙 Wiring, Test 占쏙옙 instance DI
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Test
	public void testAddUser() throws Exception {
		
		User user = new User();
		user.setUserId("testUserId");
		user.setUserName("testUserName");
		user.setPassword("testPasswd");
		user.setSsn("1111112222222");
		user.setPhone("111-2222-3333");
		user.setAddr("test");
		user.setEmail("test@test.com");
		
		userService.addUser(user);
		
		user = userService.getUser("testUserId");

		//==> console 확占쏙옙
		//System.out.println(user);
		
		//==> API 확占쏙옙
		Assert.assertEquals("testUserId", user.getUserId());
		Assert.assertEquals("testUserName", user.getUserName());
		Assert.assertEquals("testPasswd", user.getPassword());
		Assert.assertEquals("111-2222-3333", user.getPhone());
		Assert.assertEquals("test", user.getAddr());
		Assert.assertEquals("test@test.com", user.getEmail());
	}
	
	//@Test
	public void testGetUser() throws Exception {
		
		User user = new User();
		//==> 占십울옙占싹다몌옙...
//			user.setUserId("testUserId");
//			user.setUserName("testUserName");
//			user.setPassword("testPasswd");
//			user.setSsn("1111112222222");
//			user.setPhone("111-2222-3333");
//			user.setAddr("占쏙옙竪�");
//			user.setEmail("test@test.com");
		
		user = userService.getUser("testUserId");

		//==> console 확占쏙옙
		//System.out.println(user);
		
		//==> API 확占쏙옙
		Assert.assertEquals("testUserId", user.getUserId());
		Assert.assertEquals("testUserName", user.getUserName());
		Assert.assertEquals("testPasswd", user.getPassword());
		Assert.assertEquals("111-2222-3333", user.getPhone());
		Assert.assertEquals("占쏙옙竪�", user.getAddr());
		Assert.assertEquals("test@test.com", user.getEmail());

		Assert.assertNotNull(userService.getUser("user02"));
		Assert.assertNotNull(userService.getUser("user05"));
	}
	
	//@Test
	 public void testUpdateUser() throws Exception{
		 
		User user = userService.getUser("testUserId");
		Assert.assertNotNull(user);
		
		Assert.assertEquals("testUserName", user.getUserName());
		Assert.assertEquals("111-2222-3333", user.getPhone());
		Assert.assertEquals("占쏙옙竪�", user.getAddr());
		Assert.assertEquals("test@test.com", user.getEmail());

		user.setUserName("change");
		user.setPhone("777-7777-7777");
		user.setAddr("change");
		user.setEmail("change@change.com");
		
		userService.updateUser(user);
		
		user = userService.getUser("testUserId");
		Assert.assertNotNull(user);
		
		//==> console 확占쏙옙
		//System.out.println(user);
			
		//==> API 확占쏙옙
		Assert.assertEquals("change", user.getUserName());
		Assert.assertEquals("777-7777-7777", user.getPhone());
		Assert.assertEquals("change", user.getAddr());
		Assert.assertEquals("change@change.com", user.getEmail());
	 }
	 
	//@Test
	public void testCheckDuplication() throws Exception{

		//==> 占십울옙占싹다몌옙...
//			User user = new User();
//			user.setUserId("testUserId");
//			user.setUserName("testUserName");
//			user.setPassword("testPasswd");
//			user.setSsn("1111112222222");
//			user.setPhone("111-2222-3333");
//			user.setAddr("占쏙옙竪�");
//			user.setEmail("test@test.com");
//			
//			userService.addUser(user);
		
		//==> console 확占쏙옙
		//System.out.println(userService.checkDuplication("testUserId"));
		//System.out.println(userService.checkDuplication("testUserId"+System.currentTimeMillis()) );
	 	
		//==> API 확占쏙옙
		Assert.assertFalse( userService.checkDuplication("testUserId") );
	 	Assert.assertTrue( userService.checkDuplication("testUserId"+System.currentTimeMillis()) );
		 	
	}
	
	 //==>  占쌍쇽옙占쏙옙 풀占쏙옙 占쏙옙占쏙옙占싹몌옙....
	 //@Test
	 public void testGetUserListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = userService.getUserList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확占쏙옙
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = userService.getUserList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	//==> console 확占쏙옙
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 //@Test
	 public void testGetUserListByUserId() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("admin");
	 	Map<String,Object> map = userService.getUserList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console 확占쏙옙
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = userService.getUserList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console 확占쏙옙
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 //@Test
	 public void testGetUserListByUserName() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("SCOTT");
	 	Map<String,Object> map = userService.getUserList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확占쏙옙
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = userService.getUserList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console 확占쏙옙
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }	 
}