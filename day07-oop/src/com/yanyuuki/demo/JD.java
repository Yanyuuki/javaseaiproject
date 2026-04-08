package com.yanyuuki.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JD implements Switch{
    private String name;
    private boolean isOn;//默认false

    @Override
    public void press() {
        isOn=!isOn;
    }
}
