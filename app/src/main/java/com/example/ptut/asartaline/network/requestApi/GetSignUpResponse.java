package com.example.ptut.asartaline.network.requestApi;

import com.example.ptut.asartaline.network.base.BaseResponse;
import com.example.ptut.asartaline.persistence.vos.SignUpVO;
import com.google.gson.annotations.SerializedName;

public class GetSignUpResponse extends BaseResponse {

    private SignUpVO registeredUser;

    public SignUpVO getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(SignUpVO registeredUser) {
        this.registeredUser = registeredUser;
    }
}
