(function() {
    'use strict';

    angular
        .module('blog01App')
        .controller('StaticController', StaticController);

    StaticController.$inject = ['Static'];

    function StaticController() {

        var vm = this;

    }
})();
