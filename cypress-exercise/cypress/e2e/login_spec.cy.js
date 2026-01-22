describe('Kịch bản Đăng nhập (Login)', () => {

    beforeEach(() => {
        cy.visit('https://www.saucedemo.com');
    });

    it('Kịch bản 1: Đăng nhập thành công', () => {
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
        
        // Kiểm tra URL xem có chứa /inventory.html không
        cy.url().should('include', '/inventory.html');
    });

    it('Kịch bản 2: Đăng nhập thất bại (Sai thông tin)', () => {
        cy.get('#user-name').type('invalid_user');
        cy.get('#password').type('wrong_password');
        cy.get('#login-button').click();

        // Kiểm tra thông báo lỗi
        cy.get('.error-message-container')
            .should('be.visible')
            .and('contain', 'Username and password do not match');
    });
});