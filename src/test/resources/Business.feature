Feature: Validating Velsbusiness application by using API Rest Assured

  Scenario: verify user should login with valid username and password by using login endpoint
    When user should add header "Content-Type" and "application/json"
    And user should add request body for login
    And user should send post request for login
    Then user should verify statusCode for  matched with 200
    And user should verify response body for login "Login successfully"


  Scenario: verify user should to create addAddress using addUserAddress endpoint
    When user should add header "Content-Type" ,"application/json" and add bearer authentication to authorize endpoint
    And user should add request body for addUserAddress
    And user should send post request for addUserAddress
    Then  user should verify statusCode for  matched with 200
    Then user should verify response body for addUserAddress "Address added successfully"

  Scenario: verify user should  to update the addUserAddress  using updateUserAddress endpoint
    When  user should add header "Content-Type" ,"application/json" and add bearer authentication to authorize endpoint
    And user should add request body for updateUserAddress
    And user should send put request for updateUserAddress
    Then  user should verify statusCode for  matched with 200
    When user should verify response body for updateUserAddress "Address updated successfully"

  Scenario: verify user should  get the updatedUserAddress using getUserAddress endpoint
    When  user should add header "Content-Type" ,"application/json" and add bearer authentication to authorize endpoint
    And user should send get request for getUserAddress
    Then  user should verify statusCode for  matched with 200
    When user should verify response body for getAddress "OK"

  Scenario: verify user should  delete the updatedAddress using add deleteUserAddresse endpoint
    When  user should add header "Content-Type" ,"application/json" and add bearer authentication to authorize endpoint
    And user should add request body for daleteUserAddress
    And user should send delete request for deleteUserAddress
    Then user should verify statusCode for  matched with 200
    Then user should verify response body for deleteAddress "Address deleted successfully"
    
     Scenario: verify user should to logout using logoutAddess endpoint
    When user should add header "Content-Type" ,"application/json" and add bearer authentication to authorize endpoint
    And user should send post request for logoutUserAddress
    Then  user should verify statusCode for  matched with 200
    Then user should verify response body for logoutuserAddress "You have logged out"
    
    
    
