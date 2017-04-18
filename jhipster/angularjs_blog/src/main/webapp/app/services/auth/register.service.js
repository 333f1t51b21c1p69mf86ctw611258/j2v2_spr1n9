(function () {
    'use strict';

    angular
        .module('angularjsBlogApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
