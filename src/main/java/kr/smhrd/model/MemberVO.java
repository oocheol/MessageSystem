package kr.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // �⺻ �޼��� ����
@AllArgsConstructor // ��� �ʵ带 �Ű������� �޴� ������
@NoArgsConstructor// �ƹ��͵� ������� ���� ������
@RequiredArgsConstructor // @NonNull�� ���� �ʵ常 ���� ������
public class MemberVO {
	
	@NonNull
	private String email;
	@NonNull
	private String pw;
	private String tel;
	private String address;

}
