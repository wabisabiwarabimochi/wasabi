package model;

import dao.LoginDAO;

public class LoginLogic {
  public int execute(String empid,String emppasswd) {
	  LoginDAO ldao = new LoginDAO();
	  int role = ldao.loginexe(empid,emppasswd);
    return role;
  }
}