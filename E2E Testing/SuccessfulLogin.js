
// using CodeceptJS framework

test('Successful Login', async t => {
    // Go to the login page
    await t.navigateTo('https://etalente.co.za/login');
  
    // Enter the username and password
    await t.typeText('#username', 'your_username');
    await t.typeText('#password', 'your_password');
  
    // Click the login button
    await t.click('#login-button');
  
    // Assert that the user is logged in
    await t.expect(t.url).contains('/dashboard');
  });