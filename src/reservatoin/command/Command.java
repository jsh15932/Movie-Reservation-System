package reservatoin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reservation.frontController.ActionForward;

// ��Ʈ�ѷ� ���� ������ ���¸� ����ݴϴ�.
public interface Command {

	ActionForward execute(HttpServletRequest request, HttpServletResponse response);

}