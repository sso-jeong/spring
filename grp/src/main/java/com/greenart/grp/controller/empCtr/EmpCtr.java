package com.greenart.grp.controller.empCtr;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.greenart.grp.model.BuseoVO;
import com.greenart.grp.model.EmpVO;
import com.greenart.grp.model.GradeVO;
import com.greenart.grp.paging.Pager;
import com.greenart.grp.service.IDnRegSrv.IDnRegSrv;
import com.greenart.grp.service.empSrv.EmpSrv;

@Controller
@RequestMapping("/employee")
public class EmpCtr {
	
	@Autowired
	EmpSrv eSrv;
	
	@Autowired
	IDnRegSrv irSrv;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/grp_employee_list")
	public ModelAndView empList(@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "emp_name") String searchOpt, @RequestParam(defaultValue = "") String words) {
		ModelAndView mav = new ModelAndView();		
		
		int count = eSrv.getEmpCount(searchOpt, words);
		
		Pager pager = new Pager(count, curPage);

		int start = pager.getPageBegin(); // 0 ~ 10 -> 11 ~ 20 -> 21 ~ 30
		int end = pager.getPageEnd();		
		
		List<EmpVO> list = eSrv.getEmpList(start, end, searchOpt, words);
		
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("searchOpt", searchOpt);
		mav.addObject("words", words);
		
		mav.addObject("start", start); // 게시물 개수 자를 시작번호
		mav.addObject("end", end); // 게시물 자를 끝번호
		
		mav.addObject("blockBegin", pager.getBlockBegin());
		mav.addObject("blockEnd", pager.getBlockEnd());
		mav.addObject("curBlock", pager.getCurBlock());
		mav.addObject("totalBlock", pager.getTotBlock());
		
		mav.addObject("prevPage", pager.getPrevPage());
		mav.addObject("nextPage", pager.getNextPage());
		mav.addObject("curPage", pager.getCurPage());
		mav.addObject("totalPage", pager.getTotPage());
		
		// 페이지 번호를 클릭했을 때 css active 클래스 처리
		mav.addObject("selected", pager.getCurPage());
		
		mav.setViewName("grp_employee/grp_employee_list");
		return mav;
	}
	
	@RequestMapping(value ="/grp_employee_delete", method = RequestMethod.POST)
	@ResponseBody
	public String grpEmpDelete(@RequestParam int eid) {
		eSrv.setEmpDelete(eid);
		return "success";
	}
	
	@RequestMapping(value ="/grp_employee_head_change", method = RequestMethod.POST)
	@ResponseBody
	public String setEmpHeadChange(@RequestParam String empHead, @RequestParam int empID) {
		eSrv.setEmpHeadChange(empHead, empID);
		return "success";
	}
	
	
	@RequestMapping(value ="/grp_employee_confirm_change", method = RequestMethod.POST)
	@ResponseBody
	public String setEmpConfirmChange(@RequestParam String empConfirm, @RequestParam int empID) {
		eSrv.setEmpConfirmChange(empConfirm, empID);
		return "success";
	}
	
	
	@RequestMapping(value ="/grp_employee_auth_change", method = RequestMethod.POST)
	@ResponseBody
	public String setEmpAuthChange(@RequestParam String empAuth, @RequestParam int empID) {
		eSrv.setEmpAuthChange(empAuth, empID);
		return "success";
	}
	
	@RequestMapping(value = "grp_employee_register", method = RequestMethod.GET)
	public ModelAndView grpEmpReg(HttpSession session) {
		//System.out.println(session.getAttribute("empNum"));
		String sessionNum = (String) session.getAttribute("empNum");
		
		EmpVO evo = eSrv.getEmpOne(sessionNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("empOne", evo);
		mav.setViewName("grp_employee/grp_employee_register");
		
		return mav;
	}
	
	@RequestMapping(value = "/grp_register", method = RequestMethod.GET)
	public String getGrpRegister() {
		return "grp_register";
	}
	
	@RequestMapping(value = "/grp_admin_register", method = RequestMethod.POST)
	public String setGrpRegister(@ModelAttribute EmpVO evo) {
		int enterYear 	= Integer.parseInt(evo.getEmpEnter().substring(0, 4));
		String bCode 	= evo.getEmpBuseoCode();
		String gCode	= evo.getEmpGradeCode();
		
		String eNum		= enterYear + bCode + gCode;
		evo.setEmpNum(eNum);
		System.out.println(evo.getEmpNum());
		
		Calendar cal = Calendar.getInstance();
		int hYear = cal.get(Calendar.YEAR);
		int eStep = (hYear - enterYear) + 1;
		evo.setEmpStep(eStep);
		
		/* �꽑�깮 �궗�썝 �젙蹂� �엯�젰 */
		eSrv.setEmpRegOthers(evo);
		/* �꽑�깮 �궗�썝 �젙蹂� �엯�젰 */
		
		/* �뙆�씪 �뾽濡쒕뱶*/
		/* �뙆�씪 �뾽濡쒕뱶*/
		
		return "redirect:/employee/grp_employee_list";
	}
	
	@RequestMapping(value = "/grp_employee_delete_all", method = RequestMethod.POST)
	@ResponseBody
	public String grpEmpDelete(@RequestParam(value ="chkArr[]") List<String> chkArr) {
		//System.out.println(chkArr);
		
		int eid;
		for(String list : chkArr) {
			eid = Integer.parseInt(list);
			eSrv.setEmpDeleteAll(eid);
			
		}
		return "";
	}
	
	@RequestMapping(value = "/grp_get_buseo", method = RequestMethod.POST)
	@ResponseBody
	public List<BuseoVO> grpGetBuseo() {
		List<BuseoVO> list = eSrv.grpGetBuseo();
		return list;
	}
	
	@RequestMapping(value = "/grp_get_grade", method = RequestMethod.POST)
	@ResponseBody
	public List<GradeVO> grpGetGrade() {
		List<GradeVO> list = eSrv.grpGetGrade();
		return list;
	}
	
}









