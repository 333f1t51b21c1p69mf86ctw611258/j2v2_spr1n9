(function() {
    'use strict';

    angular
        .module('blog01App')
        .controller('BlogController', BlogController);

    BlogController.$inject = ['Blog'];

    function BlogController(Blog) {

        var vm = this;

        vm.blogs = [];

        loadAll();

        function loadAll() {
            Blog.query(function(result) {
                vm.blogs = result;
                vm.searchQuery = null;
            });
        }
    }
})();
