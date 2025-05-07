package com.shinhan.dept;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.shinhan.common.CommonControllerInterface;
import com.shinhan.emp.DateUtil;
import com.shinhan.emp.EmpService;
import com.shinhan.emp.EmpView;

import travelplan.common.EmpDTO;

//Controller(사용자가 요청하면 응답을 받고 처리하고 응답을 보낸다.) (Servlet으로 변경할 예정이다.)
//Web아니고 Console로 동작하는 프로그램이므로 키보드 입력을 이용(System.in)
public class DeptController implements CommonControllerInterface {
	static Scanner sc = new Scanner(System.in);
	static DeptService deptService = new DeptService();
	
	@Override
	public void execute() {
		boolean isStop = false;
		while (!isStop) {
			DeptView.menuDisplay();
			String job = sc.nextLine();

			switch (job) {
			case "all" -> {
				f_all();
			}
			case "detail" -> {
				f_detail();
			}
			case "i" -> {
				f_insert();
			}
			case "u" -> {
				f_update();
			}
			case "d" -> {
				f_delete();
			}
			case "exit" -> {
				isStop = true;
			}
			}
		}
		DeptView.display("프로그램 종료");
		
	}

	
	private static void f_all() {
	    List<DeptDTO> deptlist = deptService.selectAll();
	    DeptView.display(deptlist);
	}

	private static void f_detail() {
	    int deptid = parseInt(dataInsert("조회할 부서번호 >>> "));
	    DeptView.display(deptService.selectById(deptid));

	}

	private static void f_insert() {
	    DeptDTO dept = makeDept("입력");
	    int result = deptService.insertDept(dept);
	    DeptView.display(result + "건 입력");
	}

	private static void f_update() {
	    DeptDTO dept = makeDept("수정");
	    int result = deptService.updateDept(dept);
	    DeptView.display(result + "건 수정");
	}

	private static void f_delete() {
	    int deptid = parseInt(dataInsert("삭제할 부서번호 >>> "));
	    int result = deptService.deleteDept(deptid);
	    DeptView.display(result + "건 삭제");
	}

	private static DeptDTO makeDept(String title) {
	    System.out.println("=== 부서 정보 " + title + " ===");
	    int deptid = parseInt(dataInsert("부서번호 >>> "));
	    String deptname = dataInsert("부서이름 >>> ");
	    int mgrid = parseInt(dataInsert("매니저번호 >>> "));
	    int locid = parseInt(dataInsert("지역번호 >>> "));

	    return DeptDTO.builder()
	            .department_id(deptid)
	            .department_name(deptname)
	            .manager_id(mgrid)
	            .location_id(locid)
	            .build();
	}

	private static String dataInsert(String column) {
	    System.out.print(column);
	    return sc.nextLine();
	}

	private static int parseInt(String data) {
	    try {
	        return Integer.parseInt(data.trim());
	    } catch (NumberFormatException e) {
	        return 0;
	    }
	}
}
