package request;

import javax.validation.constraints.NotNull;

public class DealRequest {

    @NotNull
    public Integer number;

    @NotNull
    public String name;

    @NotNull
    public Boolean done;

}
