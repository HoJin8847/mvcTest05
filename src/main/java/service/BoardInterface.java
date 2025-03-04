package service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스는 작업설계서일 뿐임 메소드에 대괄호 존재 x
public interface BoardInterface {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException;
}
