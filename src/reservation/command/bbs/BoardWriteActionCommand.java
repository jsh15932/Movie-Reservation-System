package reservation.command.bbs;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reservation.dao.BbsDAO;
import reservation.frontController.ActionForward;
import reservation.util.ModalUtil;
import reservatoin.command.Command;

public class BoardWriteActionCommand implements Command {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		boolean isRedirect = true;
		String viewPage = "boardListView.reservation";
		HttpSession session = request.getSession();
		
		String userID = null;
		String bbsTitle = null;
		String bbsContent = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		if(request.getParameter("bbsTitle") != null) {
			bbsTitle = (String) request.getParameter("bbsTitle");
		}
		if(request.getParameter("bbsContent") != null) {
			bbsContent = (String) request.getParameter("bbsContent");
		}
		if(userID == null) {
			session.setAttribute("modal", new ModalUtil("���� �޽���", "�α����� ���� ���ּ���.", ModalUtil.ERROR));
			viewPage = "userLoginView.reservation";
		} else {
			if (bbsTitle == null || bbsContent == null) {
				session.setAttribute("modal", new ModalUtil("���� �޽���", "�Է��� �� �� ������ �ֽ��ϴ�.", ModalUtil.ERROR));
				viewPage = "boardWriteView.reservation";
			} else {
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.write(bbsTitle, userID, bbsContent);
				if (result == -1) {
					session.setAttribute("modal", new ModalUtil("���� �޽���", "������ �߻��߽��ϴ�.", ModalUtil.ERROR));
					viewPage = "boardWriteView.reservation";
				} else {
					session.setAttribute("modal", new ModalUtil("���� �޽���", "���������� �ۼ��߽��ϴ�.", ModalUtil.SUCCESS));
				}
			}
		}
		
		return new ActionForward(isRedirect, viewPage);
	}
	
}
