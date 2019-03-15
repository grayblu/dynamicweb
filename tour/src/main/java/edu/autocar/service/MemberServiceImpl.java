package edu.autocar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.autocar.dao.MemberDao;
import edu.autocar.domain.Member;
import edu.autocar.domain.PageInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository	// SQL에러를 처리해 주기 때문에 해당 어노테이션을 사용하여 bean 객체 등록
public class MemberServiceImpl implements MemberService {
	private List<Member> memberList;
	final private int PER_PAGE_COUNT = 10;
	
	@Autowired
	MemberDao dao;
	
/*	//	싱글톤 패턴
	static private MemberService service = new MemberServiceImpl();
*/	
	public MemberServiceImpl() {
		memberList = Collections.synchronizedList(new ArrayList<>());
		
	}
	
//	***	페이지네이션 ***
	@Override
	public PageInfo<Member> getList(int page) throws Exception {
		// TODO Auto-generated method stub
		int start = (page-1)*PER_PAGE_COUNT;
		int end = start+PER_PAGE_COUNT;
		
		int totalcount = dao.count();
		List<Member> list = dao.getPage(start, end);
		
		return new PageInfo<>(memberList.size(),
				(int)Math.ceil(memberList.size()/(double)PER_PAGE_COUNT), 
				page, PER_PAGE_COUNT, list);
	}
	
	@Override
	public Member getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(userId);
	}
	
	@Override
	public void create(Member member) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(member);
	}

	@Override
	public boolean update(Member member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int userId, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
