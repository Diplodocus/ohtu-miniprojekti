import miniprojekti.*;
import miniprojekti.reference.*;

description 'User can add a reference'

scenario "Article type reference is created with mandatory entries", {
    given 'command add selected', {
    }
    when 'all mandatory fields are entered', {
    }
    then 'new reference is created', {
    }
}

scenario "Article type reference is not created if missing mandatory entries", {
    given 'command add selected', {
    }
    when 'mandatory field is left empty', {
    }
    then 'new reference is not created', {
    }
}