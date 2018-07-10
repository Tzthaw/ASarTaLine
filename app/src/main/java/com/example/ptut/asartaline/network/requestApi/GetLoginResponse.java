package com.example.ptut.asartaline.network.requestApi;

import com.example.ptut.asartaline.network.base.BaseResponse;
import com.example.ptut.asartaline.persistence.vos.LoginVO;

public class GetLoginResponse extends BaseResponse {

    private LoginVO loginUser;

    public LoginVO getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginVO loginUser) {
        this.loginUser = loginUser;
    }
}
