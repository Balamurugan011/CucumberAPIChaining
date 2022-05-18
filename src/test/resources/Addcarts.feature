Feature: CRUD operation perforing in VelsBusinee by using Rest Assured Api


  Scenario: verify user should login with valid username and password by using login endpoint
    When user should add header "Content-Type" and "application/json"
    And user should add request body for login
    And user should send post request for login
    Then user should verify statusCode for  matched with 200
    And user should verify response body for login "Login successfully"
    
    
  Scenario: verify user should add cartItems by using addcarditem endpoint
    When user should add header "Content-Type" and "application/json" and add bearer authentication to authorize endpoint
    And user should add request body for addcardItems
    And user should send post request for addcardItems
    Then user should verify statusCode for  matched with 200
    And user should verify response body for addcarditem "Product added in cart"
    
    
  Scenario: verify user should get cartitems by using getcarditem endpoint
  When user should add header "Content-Type" and "application/json" and add bearer authentication to authorize endpoint
    And user should send get request for getcarditem
    Then user should verify statusCode for  matched with 200
    And user should verify response body for getcartitem "OK"
    
    
  Scenario: verify user should delete cartitem by using delete carditem endpoint
    When user should add header "Content-Type" and "application/json" and add bearer authentication to authorize endpoint
    And user should add request body for deletecarditem
    And user should delete request for deletecartitem
    Then user should verify statusCode for  matched with 200
    And user should verify response body for delete "Item has been removed from cart	"
    
    
  Scenario: verify user should clearcart by using clearcart endpoint
    When user should add header "Content-Type" and "application/json" and add bearer authentication to authorize endpoint
    And user should send get request for clearcart
    Then user should verify statusCode for  matched with 200
    And user should verify response body for clearcart "Cart has been cleared"
