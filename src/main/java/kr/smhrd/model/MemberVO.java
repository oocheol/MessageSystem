package kr.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // 기본 메서드 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@NoArgsConstructor// 아무것도 들어있지 않은 생성자
@RequiredArgsConstructor // @NonNull이 붙은 필드만 갖는 생성자
public class MemberVO {
	
	@NonNull
	private String email;
	@NonNull
	private String pw;
	private String tel;
	private String address;

}
