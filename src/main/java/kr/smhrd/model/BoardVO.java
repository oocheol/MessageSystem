package kr.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	
	private int num;
	private String writer;
	private String title;
	private String fileName;
	private String content;
	private String day;
	
}
