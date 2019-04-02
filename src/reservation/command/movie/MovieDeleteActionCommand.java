package reservation.command.movie;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reservation.dao.BbsDAO;
import reservation.dao.MovieDAO;
import reservation.dto.BbsDTO;
import reservation.frontController.ActionForward;
import reservation.util.ModalUtil;
import reservatoin.command.Command;

public class MovieDeleteActionCommand implements Command {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		boolean isRedirect = true;
		String viewPage = "movieManageView.reservation";
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		if(userID == null) {
			session.setAttribute("modal", new ModalUtil("���� �޽���", "�α����� ���� ���ּ���.", ModalUtil.ERROR));
			viewPage = "userLoginView.reservation";
		} else {
			int movieID = 0;
			if (request.getParameter("movieID") != null) {
				movieID = Integer.parseInt(request.getParameter("movieID"));
			}
			if(movieID == 0) {
				session.setAttribute("modal", new ModalUtil("���� �޽���", "��ȿ���� ���� ���Դϴ�.", ModalUtil.ERROR));
				viewPage = "mainView.reservation";
				isRedirect = true;
			} else {
				MovieDAO movieDAO = new MovieDAO();
				int result = movieDAO.delete(movieID);
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
