package com.example.demo.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "ユーザーネームを入力してください")
  @Size(max = 50, message = "名前は50字以内で入力してください")
  private String name;
  /**
   * 住所
   */
  @Size(max = 255, message = "住所は255桁以内で入力してください")
  private String email;
  /**
   * 電話番号
   */
  @Size()
  private String password;
}