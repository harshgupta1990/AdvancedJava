package com.example.javawebtutor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.javawebtutor.form.LoginForm;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm) form;

		if (loginForm.getUserName() == null || loginForm.getPassword() == null
				|| !loginForm.getUserName().equalsIgnoreCase("harshit")
				|| !loginForm.getPassword().equals("admin")) {
			return mapping.findForward("failure");
		} else
			return mapping.findForward("success");
	}

}
