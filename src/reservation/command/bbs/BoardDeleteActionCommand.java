package reservation.command.bbs;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reservation.dao.BbsDAO;
import reservation.dto.BbsDTO;
import reservation.frontController.ActionForward;
import reservation.util.ModalUtil;
import reservatoin.command.Command;

public class BoardDeleteActionCommand implements Command {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		boolean isRedirect = true;
		String viewPage = "boardListView.reservation";
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
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
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.delete(bbsID);
				if (result == -1) {
					session.setAttribute("modal", new ModalUtil("���� �޽���", "������ �߻��߽��ϴ�.", ModalUtil.ERROR));
				} else {
					session.setAttribute("modal", new ModalUtil("���� �޽���", "���������� �����Ǿ����ϴ�.", ModalUtil.SUCCESS));
				}
			}
		}
		
		return new ActionForward(isRedirect, viewPage);
	}
	
}

