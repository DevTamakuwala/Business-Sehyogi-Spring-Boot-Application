package com.businesssehyogi.BusinessSehyogi.wrapper;

import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.User;

public class UserInvestorWrapper {
    private User user;
    private Investor investor;

    public UserInvestorWrapper() {
    }

    public UserInvestorWrapper(User user, Investor investor) {
        this.user = user;
        this.investor = investor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
