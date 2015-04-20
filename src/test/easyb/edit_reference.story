import miniprojekti.*;
import miniprojekti.reference.*;

description 'User can edit or delete a reference'

scenario "User can edit a reference", {
    given 'command edit selected', {
    }
    when 'all mandatory fields are entered', {
    }
    then 'changes are saved', {
    }
}

scenario "User can delete a reference", {
    given 'command delete selected', {
    }
    when 'action is confirmed', {
    }
    then 'reference is deleted', {
    }
}

scenario "User can't delete a reference without confirmation", {
    given 'command delete selected', {
    }
    when 'action is not confirmed', {
    }
    then 'reference is not deleted', {
    }
}