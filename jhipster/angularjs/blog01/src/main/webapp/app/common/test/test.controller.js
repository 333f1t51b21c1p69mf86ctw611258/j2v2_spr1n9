(function() {
    'use strict';

    angular
        .module('blog01App')
        .controller('TestController', TestController);

    TestController.$inject = ['Test'];

    function TestController() {

        var vm = this;

    }
})();
