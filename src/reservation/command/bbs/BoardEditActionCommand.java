package reservation.command.bbs;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reservation.dao.BbsDAO;
import reservation.dto.BbsDTO;
import reservation.frontController.ActionForward;
import reservation.util.ModalUtil;
import reservatoin.command.Command;

public class BoardEditActionCommand implements Command {

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
			int bbsID = 0;
			if (request.getParameter("bbsID") != null) {
				bbsID = Integer.parseInt(request.getParameter("bbsID"));
			}
			if(bbsID == 0) {
				session.setAttribute("modal", new ModalUtil("���� �޽���", "��ȿ���� ���� ���Դϴ�.", ModalUtil.ERROR));
				viewPage = "mainView.reservation";
				isRedirect = true;
			}
			BbsDTO bbs = new BbsDAO().getBbs(bbsID);
			if (bbs.getBbsAvailable() == 0) {
				session.setAttribute("modal", new ModalUtil("���� �޽���", "������ ���Դϴ�.", ModalUtil.ERROR));
				viewPage = "mainView.reservation";
				isRedirect = true;
			}
			if (!userID.equals(bbs.getUserID())) {
				session.setAttribute("modal", new ModalUtil("���� �޽���", "������ �����ϴ�.", ModalUtil.ERROR));
				viewPage = "mainView.reservation";
				isRedirect = true;
			} else {
				if (bbsTitle == null || bbsContent == null) {
					session.setAttribute("modal", new ModalUtil("���� �޽���", "�Է��� �� �� ������ �ֽ��ϴ�.", ModalUtil.ERROR));
				} else {
					BbsDAO bbsDAO = new BbsDAO();
					int result = bbsDAO.update(bbsID, bbsTitle, bbsContent);
					if (result == -1) {
						session.setAttribute("modal", new ModalUtil("���� �޽���", "������ �߻��߽��ϴ�.", ModalUtil.ERROR));
					} else {
						session.setAttribute("modal", new ModalUtil("���� �޽���", "���������� �ۼ��߽��ϴ�.", ModalUtil.SUCCESS));
					}
				}
			}
		}
		
		return new ActionForward(isRedirect, viewPage);
	}
	
}