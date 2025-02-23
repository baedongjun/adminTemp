"use strict";
(function($) {
        "use strict";
        $('#minMaxExample').datepicker({
            language: 'en',
            minDate: new Date()
        })
        var disabledDays = [0, 6];
        $('#disabled-days').datepicker({
            language: 'en',
            onRenderCell: function(date, cellType) {
                if (cellType == 'day') {
                    var day = date.getDay()
                        , isDisabled = disabledDays.indexOf(day) != -1;
                    return {
                        disabled: isDisabled
                    }
                }
            }
        })
    }
)(jQuery);
