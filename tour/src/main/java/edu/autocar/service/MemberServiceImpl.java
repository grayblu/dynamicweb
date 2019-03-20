package edu.autocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.autocar.dao.MemberDao;
import edu.autocar.domain.Member;
import edu.autocar.domain.PageInfo;
import edu.autocar.util.SHA256Util;


@Repository	// SQL에러를 처리해 주기 때문에 해당 어노테이션을 사용하여 bean 객체 등록
public class MemberServiceImpl implements MemberService {
	
	final private int PER_PAGE_COUNT = 10;
	
	@Autowired
	MemberDao dao;

	
	
//	***	페이지네이션 ***
	@Override
	public PageInfo<Member> getList(int page) throws Exception {
		// TODO Auto-generated method stub
		int start = (page-1)*PER_PAGE_COUNT;
		int end = start+PER_PAGE_COUNT;
		
		int totalcount = dao.count();
		List<Member> list = dao.getPage(start, end);
		
		return new PageInfo<>(totalcount,
				(int)Math.ceil(totalcount/(double)PER_PAGE_COUNT), 
				page, PER_PAGE_COUNT, list);
	}
	
	@Override
	public Member getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(userId);
	}
	
	@Transactional
	@Override
	public void create(Member member) throws Exception {
		// TODO Auto-generated method stub
		// salt 생성 및 비번 암호화
		String salt = SHA256Util.generateSalt();
		String encPassword = SHA256Util.getEncrypt(member.getPassword(), salt);
		
		member.setSalt(salt);
		member.setPassword(encPassword);
		dao.insert(member);
	}
	
	@Transactional
	@Override
	public boolean updateByAdmin(Member member) throws Exception {
	if(!checkAdminPassword(member.getPassword())) return false;
	return dao.updateByAdmin(member)==1;
	}
	
	private boolean checkAdminPassword(String password) throws Exception{
		Member admin = dao.findById("admin");
		String adminPassword = admin.getPassword();
		password = SHA256Util.getEncrypt(
		password, // 입력받은 비밀번호
		admin.getSalt()); // admin의 salt
		return adminPassword.equals(password);
	}
	@Override
	public Member checkPassword(String userId, String password) throws Exception {
		// TODO Auto-generated method stub
		Member user = dao.findById(userId);
		
		if(user != null) { // 사용자 ID가 존재하는 경우
			password = SHA256Util.getEncrypt(password, user.getSalt());
			if(password.equals(user.getPassword()))
			return user;
		}
			
		// ID가 없거나 비밀번호가 다른 경우
		return null;
	}
	
	@Override
	public boolean update(Member member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional
	@Override
	public boolean delete(String userId, String password) throws Exception {
		// TODO Auto-generated method stub
		if(!checkAdminPassword(password)) return false;
		
		return dao.delete(userId) == 1;
		
	}
}
