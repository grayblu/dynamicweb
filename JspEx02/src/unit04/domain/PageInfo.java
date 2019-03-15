package unit04.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {
	int totalCount;
	int totalPage;
	int page;		// 현재 페이지 번호
	int perCount;	// 한 페이지당 데이터 건수
	List<T> list;	// 해당 페이지 내 멤버목록
}
