package com.shinhan.dept;

import java.util.List;

import com.shinhan.dept.DeptDTO;

//View(Web에서 JSP로 변경될 예정이다)
public class DeptView {

	// 부서 목록 출력
	public static void display(List<DeptDTO> deptlist) {
	    if (deptlist == null || deptlist.size() == 0) {
	        display("존재하는 부서가 없습니다.");
	        return;
	    }

	    System.out.println("===== 부서 목록 =====");
	    for (DeptDTO dept : deptlist) {
	        display(dept);
	    }
	}

	// 부서 상세 정보 출력
	public static void display(DeptDTO dept) {
		if(dept == null) {
			display("해당하는 data가 존재하지 않습니다.");
			return;
		}
	    System.out.println("부서번호: " + dept.getDepartment_id());
	    System.out.println("부서이름: " + dept.getDepartment_name());
	    System.out.println("매니저번호: " + dept.getManager_id());
	    System.out.println("지역코드: " + dept.getLocation_id());
	    System.out.println("=====================");
	}

	// 알림 메시지 출력
	public static void display(String message) {
	    System.out.println("알림: " + message);
	}
	
	public static void menuDisplay() {
		System.out.println("1.모든 부서조회(all)");
		System.out.println("2.부서번호로 상세보기(detail)");
		System.out.println("3.부서 입력(i)");
		System.out.println("4.부서 수정(u)");
		System.out.println("5.부서 삭제(d)");
		System.out.println("6.exit");
		System.out.printf("작업 선택>>>>>");
	}
	
}