/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.anhduc.mathutil.core;

import static com.anhduc.mathutil.core.MathUtil.getFactorial;
//import static la danh rieng cho nhung ham static goi ham ma bo qua ten class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author ASUS
 */
public class MathUtilTest {

    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
                                {1,1},
                                {2,2},
                                {5,120},
                                {6,720}
                                
        };
    }

    

    @ParameterizedTest
    @MethodSource(value = "initData") //ten ham cung cap data, ngam dinh thu tu
    //cua cac phan tu mang, vao map vao tham so ham
    public void TestGetFactorialGivenRightReturnWell(int input,long expected) {
        assertEquals(expected, getFactorial(input));
    }

    @Test
    public void testGetFactorialGivenWrongThrowException() {
        //xai bieu thuc lambda
        //ham nhan tham so thu 2 la 1 object co code implement cai
        //functional interface ten la Executable - ca 1 ham duy nhat khong code
        Executable exeObject = () -> {
            getFactorial(-5);
        };
        assertThrows(IllegalArgumentException.class, exeObject);
    }
}
