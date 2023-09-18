package com.example.demo.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
   * メール
   */
  @NotEmpty(message = "メールアドレスを入力してください")
  private String email;
  /**
   * パスワード
   */
  @NotEmpty(message = "パスワードを入力してください")
  private String password;
}