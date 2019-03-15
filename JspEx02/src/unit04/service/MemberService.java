package unit04.service;

import unit04.domain.Member;
import unit04.domain.PageInfo;

public interface MemberService {
	PageInfo<Member> getPage(int page);
	int getTotalPage();
	int getTotalCount();
}
