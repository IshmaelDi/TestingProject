// using TestCafe framework
Feature('Login')

Scenario('Failed Login', async ({ I }) => {
  // Go to the login page
  await I.amOnPage('https://etalente.co.za/login');

  // Enter the incorrect username and password
  await I.fillField('#username', 'incorrect_username');
  await I.fillField('#password', 'incorrect_password');

  // Click the login button
  await I.click('#login-button');

  // Assert that the user is not logged in
  await I.seeInCurrentUrl('/login');
});