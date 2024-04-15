// using CodeceptJS framework

test('Failed Login', async t => {
    
    // Go to the login page
    await t.navigateTo('https://etalente.co.za/login');
  
    // Enter the incorrect username and password
    await t.typeText('#username', 'incorrect_username');
    await t.typeText('#password', 'incorrect_password');
  
    // Click the login button
    await t.click('#login-button');
  
    // Assert that the user is not logged in
    await t.expect(t.url).contains('/login');
  });
