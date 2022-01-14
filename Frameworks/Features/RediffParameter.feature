Feature: Passing Parameter

@tag2
  Scenario Outline: Login with example
  When Login page is open "https://mail.rediff.com/cgi-bin/login.cgi"
    Given user want to enter a  username "<user>"
    When user enter password "<password>" and click login button
   Then I verify the "<status>" in step

   Examples:
    | user  | password | status  |
      | Selenium |     Seleniuim123 | fail |
      | Test |     Selenium  | fail    |
      | Dan | North | fail |
      