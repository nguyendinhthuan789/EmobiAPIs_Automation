package emobi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class C2sEntity {
    private String campaignID;
    private String tpClickId;
    private String userAgent;
    protected String operator;
}
