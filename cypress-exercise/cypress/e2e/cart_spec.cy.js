describe('Kịch bản Giỏ hàng & Thanh toán', () => {

    beforeEach(() => {
        // Đăng nhập trước mỗi test case
        cy.visit('https://www.saucedemo.com');
        cy.get('#user-name').type('standard_user');
        cy.get('#password').type('secret_sauce');
        cy.get('#login-button').click();
    });

    it('Kịch bản 3: Thêm sản phẩm vào giỏ', () => {
        cy.get('.inventory_item').first().find('.btn_inventory').click();
        cy.get('.shopping_cart_badge').should('have.text', '1');
    });

    it('Kịch bản 4: Lọc giá từ thấp đến cao', () => {
        cy.get('.product_sort_container').select('lohi');
        cy.get('.inventory_item_price').first().should('have.text', '$7.99');
    });

    it('Bài tập: Xóa sản phẩm khỏi giỏ hàng', () => {
        // Thêm trước khi xóa
        cy.get('.btn_inventory').first().click();
        cy.get('.shopping_cart_badge').should('exist');

        // Nhấn nút Remove
        cy.get('.btn_inventory').first().click();
        cy.get('.shopping_cart_badge').should('not.exist');
    });

    it('Bài tập: Quy trình thanh toán (Checkout)', () => {
        // 1. Thêm sản phẩm và vào giỏ hàng
        cy.get('.btn_inventory').first().click();
        cy.get('.shopping_cart_link').click();

        // 2. Nhấn Checkout
        cy.get('#checkout').click();

        // 3. Điền thông tin
        cy.get('#first-name').type('John');
        cy.get('#last-name').type('Doe');
        cy.get('#postal-code').type('12345');
        cy.get('#continue').click();

        // 4. Xác minh đến trang Checkout: Overview
        cy.url().should('include', '/checkout-step-two.html');
        cy.get('.title').should('contain', 'Checkout: Overview');
    });
});