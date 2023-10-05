// using TestCafe framework
Feature('Login')

Scenario('Successful Login', async ({ I }) => {
  // Go to the login page
  await I.amOnPage('https://etalente.co.za/login');

  // Enter the username and password
  await I.fillField('#username', 'your_username');
  await I.fillField('#password', 'your_password');

  // Click the login button
  await I.click('#login-button');

  // Assert that the user is logged in
  await I.seeInCurrentUrl('/dashboard');
});