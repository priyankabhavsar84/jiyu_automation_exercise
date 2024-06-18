Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Background:
      Given user is logged in with username "cur_user" and password "cur_password"

    @regression
    Scenario: Successful password change
      When user changes the password from "cur_password" to "new_secure_password" with confirmation "new_secure_password"
      Then a confirmation message "Your password has been changed successfully" is displayed

    @regression
    Scenario: Password change with non-matching confirmation
      When user attempts to change the password from "cur_password" to "new_secure_password" with confirmation "different_password"
      Then an error message "Password and confirmation do not match" is displayed

    @regression
    Scenario: Password change with insecure new password
      When user attempts to change the password from "cur_password" to "123"
      Then an error message "New password does not meet security requirements" is displayed

    @regression
    Scenario: Password change with same as old password
      When user attempts to change the password from "cur_password" to "cur_password"
      Then an error message "New password cannot be the same as the old password" is displayed

    @regression
    Scenario: Password change with insufficient length
      When user attempts to change the password from "cur_password" to "short" with confirmation "short"
      Then an error message "New password must be at least 8 characters long" is displayed