package io.namoosori.springkafka.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenantStats {
    //
    private int count;

    public void increase() {
        //
        count++;
    }

    public void decrease() {
        //
        count--;
    }
}
