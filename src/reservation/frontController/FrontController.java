package reservation.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.command.bbs.BoardDeleteActionCommand;
import reservation.command.bbs.BoardEditActionCommand;
import reservation.command.bbs.BoardEditViewCommand;
import reservation.command.bbs.BoardInfoViewCommand;
import reservation.command.bbs.BoardListViewCommand;
import reservation.command.bbs.BoardWriteActionCommand;
import reservation.command.bbs.BoardWriteViewCommand;
import reservation.command.movie.MovieChartViewCommand;
import reservation.command.movie.MovieDeleteActionCommand;
import reservation.command.movie.MovieEditActionCommand;
import reservation.command.movie.MovieEditViewCommand;
import reservation.command.movie.MovieManageViewCommand;
import reservation.command.movie.MovieWriteActionCommand;
import reservation.command.seat.PayActionCommand;
import reservation.command.seat.SeatSelectViewCommand;
import reservation.command.user.UserConfirmCommand;
import reservation.command.user.UserDeleteCommand;
import reservation.command.user.UserEditCommand;
import reservation.command.user.UserEditViewCommand;
import reservation.command.user.UserJoinCommand;
import reservation.command.user.UserJoinViewCommand;
import reservation.command.user.UserListViewCommand;
import reservation.command.user.UserLoginCommand;
import reservation.command.user.UserLogoutCommand;
import reservation.command.user.UserManageDeleteCommand;
import reservation.command.user.UserPasswordFindCommand;
import reservation.util.ServerUtil;
import reservatoin.command.Command;

@WebServlet("*.reservation")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Command command = null;
		ActionForward forward = null;
		
		String URI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String target = URI.substring(contextPath.length());
	
		/* ȸ�� - �ܼ� View ó��(Forward ó��) */
		if(target.equals(ServerUtil.relativePath + "mainView.reservation")) {
			forward = new ActionForward(false, "mainView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "userLoginView.reservation")) {
			forward = new ActionForward(false, "userLoginView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "userConfirmView.reservation")) {
			forward = new ActionForward(false, "userConfirmView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "userFindView.reservation")) {
			forward = new ActionForward(false, "userFindView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "userFindResultView.reservation")) {
			forward = new ActionForward(false, "userFindResultView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "userDeleteView.reservation")) {
			forward = new ActionForward(false, "userDeleteView.jsp");
		} 
		
		else if(target.equals(ServerUtil.relativePath + "movieWriteView.reservation")) {
			forward = new ActionForward(false, "movieWriteView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "payView.reservation")) {
			forward = new ActionForward(false, "payView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "payResultView.reservation")) {
			forward = new ActionForward(false, "payResultView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "reservationView.reservation")) {
			forward = new ActionForward(false, "reservationView.jsp");
		} else if(target.equals(ServerUtil.relativePath + "qnaView.reservation")) {
			forward = new ActionForward(false, "qnaView.jsp");
		}
		
				
		/* ȸ�� - ������ ��ȸ ó��(Forward ó��) */
		else if(target.equals(ServerUtil.relativePath + "userJoinView.reservation")) {
			command = new UserJoinViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userEditView.reservation")) {
			command = new UserEditViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardListView.reservation")) {
			command = new BoardListViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardWriteView.reservation")) {
			command = new BoardWriteViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardInfoView.reservation")) {
			command = new BoardInfoViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardEditView.reservation")) {
			command = new BoardEditViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "seatSelectView.reservation")) {
			command = new SeatSelectViewCommand();
			forward = command.execute(request, response);
		} 
		
		/* ȸ�� - ����/����/���� ó�� (Redirect ó��) */
		else if(target.equals(ServerUtil.relativePath + "userLoginAction.reservation")) {
			command = new UserLoginCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userLogoutAction.reservation")) {
			command = new UserLogoutCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userFindAction.reservation")) {
			command = new UserPasswordFindCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userConfirmAction.reservation")) {
			command = new UserConfirmCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userJoinAction.reservation")) {
			command = new UserJoinCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userDeleteAction.reservation")) {
			command = new UserDeleteCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userEditAction.reservation")) {
			command = new UserEditCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardWriteAction.reservation")) {
			command = new BoardWriteActionCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardEditAction.reservation")) {
			command = new BoardEditActionCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "boardDeleteAction.reservation")) {
			command = new BoardDeleteActionCommand();
			forward = command.execute(request, response);
		} 
		
		/* ������ */
		else if(target.equals(ServerUtil.relativePath + "movieManageView.reservation")) {
			command = new MovieManageViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "movieChartView.reservation")) {
			command = new MovieChartViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "movieWriteView.reservation")) {
			forward = new ActionForward(false, "movieWrite.jsp");
		} else if(target.equals(ServerUtil.relativePath + "movieDeleteView.reservation")) {
			command = new MovieDeleteActionCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "movieEditView.reservation")) {
			command = new MovieEditViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "movieEditAction.reservation")) {
			command = new MovieEditActionCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userListView.reservation")) {
			command = new UserListViewCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "userManageDeleteAction.reservation")) {
			command = new UserManageDeleteCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "movieWriteAction.reservation")) {
			command = new MovieWriteActionCommand();
			forward = command.execute(request, response);
		} else if(target.equals(ServerUtil.relativePath + "payAction.reservation")) {
			command = new PayActionCommand();
			forward = command.execute(request, response);
		} 
		
		
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getViewPage());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getViewPage());
			dispatcher.forward(request, response);
		}
	}
	
}
